pipeline {
    agent any
    tools {
        maven "Maven3"
        jdk "Java17"
    }
    stages {
        stage('Build') {
            steps {
                bat 'mvn -DskipTests clean package'
            }
        }
    }
}