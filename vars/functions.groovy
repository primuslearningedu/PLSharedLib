def getDockerImageTag(String version) {
    def tag = ""
    def branch = env.BRANCH_NAME.replace('/', '-').replace('\\', '-').toLowerCase()
    version = version.replace('SNAPSHOT', '').replace('RELEASE', '').replace('-', '')

    if (branch == 'main' || branch == 'master') {
        tag = "${version}.${env.BUILD_NUMBER}"
    } else {
        tag = "${version}.${env.BUILD_NUMBER}-${branch}"
    }

    return tag
}
