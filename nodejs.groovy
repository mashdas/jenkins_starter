job('Node example'){
	scm{
		git('https://github.com/mashdas/docker-demo.git') { node ->
          node / gitConfigName('manish')
          node / gitConfigEmail('mashdas94@gmail.com')

		}
	}

	triggers{
		scm('H/5 * * * *')
	}

	wrappers{
		nodejs('nodejs')
	}

	steps{
		shell("npm install")
	}
}