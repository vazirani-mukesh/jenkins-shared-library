#!/usr/bin/env groovy

import com.abc.Docker

def call() {
    return new Docker(this).dockerLogin()
}
