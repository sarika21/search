pipeline {

  environment {
    dockerimagename = "sarika21/search"
    dockerImage = ""
  }

  agent any

  stages {

    stage('Checkout Source') {
      steps {
        git 'https://tools.publicis.sapient.com/bitbucket/scm/tjdb/sarika-singh.git'
      }
    }

    stage('Build image') {
      steps{
        script {
          dockerImage = docker.build dockerimagename
        }
      }
    }

   

  }

}