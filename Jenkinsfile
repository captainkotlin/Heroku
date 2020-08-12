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
                bat "\
                    gradle build \
                    -Dcucumber.filter.tags=\"not @ignore\" \
                    -Djava.awt.headless=false \
                    -Dselenide.browser=chrome \
                    -Dselenide.remote=http://192.168.0.105:4444/wd/hub \
                    -Dorg.gradle.debug=true"
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

