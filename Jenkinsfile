pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                // Get some code from a GitHub repository
                sh "rm -rf Planit-UI-Automation"
                sh "git clone https://github.com/RAGAVIKRISHNA/Planit-UI-Automation.git"
             withMaven {
                
                // Run Maven on a Unix agent.
                sh "mvn clean verify"
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
