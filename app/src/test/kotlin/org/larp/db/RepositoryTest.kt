package org.larp.db

import kotlin.test.Test
import kotlin.test.assertNotNull

class RepositoryTest {
    @Test fun SetUpRespositoryConnector() {
        val connector = RepositoryConnector()
        assertNotNull(connector.connection)
    }
}