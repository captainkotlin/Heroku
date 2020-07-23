pipeline {
    agent any

    triggers {
        pollSCM('* * * * *')
    }

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "mvn3"
    }

    stages {
        stage('Build')
        {
                    input {
                        message "Should we continue?"
                        ok "Yes, we should."
                        submitter "alice,bob"
                        parameters {
                            string(name: 'PERSON', defaultValue: 'Mr Jenkins', description: 'Who should I say hello to?')
                        }
                    }
            // Get some code from a GitHub repository
            git 'https://github.com/captainkotlin/Heroku.git'
        }

        stage('Test') {
            steps {
                // Run Maven on a Unix agent.
                sh "mvn test"
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

