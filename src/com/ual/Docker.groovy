#!/usr/bin/env groovy

package com.ual

class Docker implements Serializable {
    def script

    Docker(script) {
        this.script = script
    }

    def buildImage(String imageName) {
        script.sh "docker build -t $imageName ."
    }

    def dockerLogin() {
        withCredentials([usernamePassword(credentialsId: 'dockerhub', passwordVariable: 'MYPSW', usernameVariable: 'USER')]) {
            script.sh "echo script.$MYPSW | docker login -u script.$USER --password-stdin"
        }
    }

    def pushImage(String imageName) {
        script.sh "docker push $imageName"
    }

}
