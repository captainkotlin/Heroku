pipeline {
    agent any

    triggers {
        pollSCM('* * * * *')
    }

    tools {
        gradle "6.3"
    }

    stages {
        stage('Build')
        {
            steps {
                // Get some code from a GitHub repository
                git 'https://github.com/captainkotlin/Heroku.git'
            }
        }

        stage('Test') {
            steps {
                // Run Maven on a Unix agent.
                bat "gradle test -Djava.awt.headless=false"
            }

            post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                    always {
                      step([$class: 'Mailer',
                        notifyEveryUnstableBuild: true,
                        recipients: "captainkotlin@gmail.com",
                        sendToIndividuals: true])
                    }
            }
        }
    }
}

