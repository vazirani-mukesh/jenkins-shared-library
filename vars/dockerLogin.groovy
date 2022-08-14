#!/usr/bin/env groovy

import com.ual.Docker

def call() {
    return new Docker(this).dockerLogin()
}