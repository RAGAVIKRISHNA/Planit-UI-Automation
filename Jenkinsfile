pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                // Get some code from a GitHub repository
                bat "rmdir /s/q Planit-UI-Automation"
                bat "git clone https://github.com/RAGAVIKRISHNA/Planit-UI-Automation.git"
                // Run Maven on a Unix agent.
                bat "set PATH=C:\Users\RAGAVI MUTHUKRISHNAN\Maven\apache-maven-3.8.1\bin%PATH%"
                bat "mvn clean verify"
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
