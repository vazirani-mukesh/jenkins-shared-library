#!/usr/bin/env groovy

import com.abc.Docker

def call(String imageName) {
    return new Docker(this).buildImage(imageName)
}
