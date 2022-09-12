#!/usr/bin/env groovy

package com.abc

class Docker implements Serializable {
    def script

    Docker(script) {
        this.script = script
    }

    def buildImage(String imageName) {
        script.sh "docker build -t $imageName ."
    }

    def dockerLogin() {
        script.withCredentials([script.usernamePassword(credentialsId: 'dockerhub', passwordVariable: 'MYPSW', usernameVariable: 'USER')]) {
            script.sh "echo $script.MYPSW | docker login -u $script.USER --password-stdin"
        }
    }

    def pushImage(String imageName) {
        script.sh "docker push $imageName"
    }
    
    def postJobCleanUp(String imageName) {
        script.sh "docker rmi -f $imageName" 
    }

}
