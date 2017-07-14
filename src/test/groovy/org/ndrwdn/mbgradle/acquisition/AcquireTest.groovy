package org.ndrwdn.mbgradle.acquisition

import org.ndrwdn.mbgradle.MbPathUtil
import org.ndrwdn.mbgradle.MountebankProjectSpec

import java.nio.file.Paths

class AcquireTest extends MountebankProjectSpec {

    def "Should download and extract when acquiring Mountebank"() {
        given:
        Acquire acquire = new Acquire(project)

        when:
        acquire.acquire()

        then:
        MbPathUtil.mbDirectory(project).exists()
    }


    def "Should download and extract when acquiring Mountebank when mb path already exists"() {
        given:
        Acquire acquire = new Acquire(project)
        MbPathUtil.mbDirectory(project).mkdirs()

        when:
        acquire.acquire()

        then:
        MbPathUtil.mbDirectory(project).exists()
    }
}
