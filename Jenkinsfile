pipeline {
    agent any

    environment {
        APP_NAME = "productmanagementsystem"
        DOCKER_IMAGE = "kumarmijar/productmanagementsystem:latest"
        GIT_CREDENTIALS = "github-cred-id"
        DOCKER_CREDENTIALS = "dockerhub-cred-id"
        DEPLOY_PORT = "8081"
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', credentialsId: "github-cred-id", url: 'https://github.com/kumarmijar123/product-management-system.git'
            }
        }

        stage('Build') {
            steps {
                echo "Building the Maven project..."
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Build Docker Image') {
            steps {
                echo "Building Docker image..."
                sh 'docker build -t kumarmijar/productmanagementsystem .'
            }
        }

        stage('Push Docker Image') {
            steps {
                echo "Logging in to Docker Hub and pushing image..."
                withCredentials([usernamePassword(credentialsId: "dockerhub-cred-id", usernameVariable: 'USER', passwordVariable: 'PASS')]) {
                    sh 'echo $PASS | docker login -u $USER --password-stdin'
                    sh 'docker push kumarmijar/productmanagementsystem'
                }
            }
        }

        stage('Deploy') {
            steps {
                echo "Stopping any running container..."
                sh "docker stop productmanagementsystem || true"
                sh "docker rm productmanagementsystem || true"
                
                echo "Running the container..."
                sh 'docker run -d -p 8081:8080 --name productmanagementsystem kumarmijar/productmanagementsystem'
            }
        }
    }

    post {
        success {
            echo "✅ Deployment Successful: ${APP_NAME} is running on port ${DEPLOY_PORT}"
        }
        failure {
            echo "❌ Pipeline Failed"
        }
    }
}

