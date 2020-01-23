node{
	def commit_id
	stage('Prep'){
		checkout scm
		sh "git rev-parse --short HEAD > .git/commit-id"
		commit_id = readFile('.git/commit-id').trim()
	}

	stage('test'){
		nodejs(nodeJSInstallationName: 'nodejs'){
			sh 'npm install --only-dev' //Will install the dev dependencies..in this case mocha..check the package.json file in docker-demo repo
			sh 'npm test' //will run the test suite
		}
	}

	stage('docker build/push'){
		docker.withRegistry('https://index.docker.io/v1/','dockerhub'){
			def app =docker.build("xlr99/docker-nodejs-demo:${commit_id}",'.').push()
		}
	}
}