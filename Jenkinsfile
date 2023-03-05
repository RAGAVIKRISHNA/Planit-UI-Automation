pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                // Get some code from a GitHub repository
                bat "git clone https://github.com/RAGAVIKRISHNA/Planit-UI-Automation.git"
             withMaven {
                
                // Run Maven on a Unix agent.
                bat "mvn clean verify"
}
            }

            post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                success {
                    junit '**/target/surefire-reports/TEST-*.xml'
                    archiveArtifacts 'target/*.jar'
                }
            }
        }
    }
}
