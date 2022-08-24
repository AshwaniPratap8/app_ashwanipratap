pipeline {
    agent any
    
    environment {
        scannerHome = tool name: 'SonarQubeScanner', type: 'hudson.plugins.sonar.SonarRunnerInstallation'
        //dockerHubUsername="ashwanipratap8"
        //nagarroUsername="ashwanipratap"
        //dockerHubCreds = 'dockerHubCreds'
    }
    
    tools {
        maven 'Maven3'
        //dockerTool 'Docker'
    }
    
    stages {
		stage('Build') {
            steps {
                git 'https://github.com/AshwaniPratap8/app_ashwanipratap.git'
                bat "mvn -DskipTests clean package"
                //Since docker was not locally available, I have built and pushed the images to docker hub manually from a client vm
                //bat "docker build -t ${dockerHubUsername}/i-${nagarroUsername}-${env.BRANCH_NAME}:latest --no-cache ."
                //script {
                //    withDockerRegistry(credentialsId: 'dockerHubCreds', toolName: 'docker') {
                //        bat "docker push ${dockerHubUsername}/i-${nagarroUsername}-${env.BRANCH_NAME}:latest"
                //    }
                //}
            }
        }
        stage('Test Case Execution') {
            when {
                branch 'master'
            }
            steps {
                bat "mvn test"
            }
        }
        stage('Sonarqube Analysis') {
            when {
               branch 'develop'
            }
            steps {
                withSonarQubeEnv('Test_Sonar') {
                    bat "${scannerHome}\\bin\\sonar-scanner"
                }
            }
        }
        stage('Kubernetes Deployment') {
            steps {
                bat 'kubectl apply -f k8s/deployment-all.yaml'
            }
        }
    }
}