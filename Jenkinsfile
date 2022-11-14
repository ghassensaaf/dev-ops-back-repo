pipeline {
  agent any

  stages {
    stage('Pull Git') {
      steps {
        echo 'Pulling ... ';
        git branch: 'ahmed', credentialsId: 'a9553f33-b2c3-4eff-94c1-a6dc9703d28d', url: 'https://github.com/ghassensaaf/dev-ops-back-repo.git';
      }
    }
    stage('MVN Clean') {
      steps {
        sh 'mvn clean';
      }
    }
    
    stage('MVN TEST') {
      steps {
        sh 'mvn test ';
      }
    }

    stage('MVN Compile') {
      steps {
        sh 'mvn compile';
      }
    }

    stage('MVN DEPLOY') {
      steps {
        sh 'mvn clean deploy -Dmaven.test.skip=true';
      }
    }

    stage('Maven SonarQube') {
      steps {
          sh 'mvn clean package sonar:sonar -Dsonar.login=admin -Dsonar.password=root'
      }
    }



    stage("Push Frontimg to DockerHub") {
      steps{
        // login to docker hub
        sh 'docker login -u ahmedfakh -p cssahmed123'
        
        // build & push angular image to docker hub
        sh 'docker build -t ahmedfakh/produit_front ./frontend/'
       
      }
    }
    
    stage("Push  backimg to DockerHub") {
      steps{
        // login to docker hub
        sh 'docker login -u ahmedfakh -p cssahmed123'

        // build & push spring image to  docker hub
        sh 'docker build -t ahmedfakh/produit_back .'
       
      }
    }


    stage('DOCKER Compose') {
      steps {
        echo 'docker compose stage';
        sh 'docker-compose up -d'
      }
    }
  }
}