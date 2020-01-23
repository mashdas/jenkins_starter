job('Node-docker'){
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
		dockerBuildAndPublish{
			repositoryName('xlr99/docker-node')
			tag('${GIT_REVISION,length=9}')
            registryCredentials('dockerhub')
            forcePull(false)
            forceTag(false)
            createFingerprints(false)
            skipDecorate()
		}
	}
}