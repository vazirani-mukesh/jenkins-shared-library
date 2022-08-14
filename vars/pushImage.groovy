#!/usr/bin/env groovy

import com.ual.Docker

def call(String imageName) {
    return new Docker(this).pushImage(imageName)
}