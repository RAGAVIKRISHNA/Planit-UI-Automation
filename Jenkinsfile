pipeline {
    agent any
    environment {
                 JAVA_HOME="C:\\Program Files\\Java\\jdk-14.0.2"
                 MVN_HOME="C:\\Users\\maven\\apache-maven-3.8.1\\bin\\mvn"
    }
    stages {
        stage('Build') {
            steps {
                // Get some code from a GitHub repository
                bat "rmdir /s/q Planit-UI-Automation"
                bat "git clone https://github.com/RAGAVIKRISHNA/Planit-UI-Automation.git"
                bat "echo %Path%"
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
