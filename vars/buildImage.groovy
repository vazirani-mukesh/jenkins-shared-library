#!/usr/bin/env groovy

import com.ual.Docker

def call(String imageName) {
    return this new Docker(this).buildImage(imageName)
}