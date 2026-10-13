package io.github.lswlc33.maibms.transport

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class BleWriteModeTest {
    @Test fun noResponseOnlyUsesNoResponse() {
        assertEquals(BleWriteMode.WithoutResponse, bleWriteMode(true, false))
    }
    @Test fun responseOnlyUsesResponse() {
        assertEquals(BleWriteMode.WithResponse, bleWriteMode(false, true))
    }
    @Test fun bothPreferNoResponse() {
        assertEquals(BleWriteMode.WithoutResponse, bleWriteMode(true, true))
    }
    @Test fun readOnlyIsRejected() {
        assertFailsWith<IllegalStateException> { bleWriteMode(false, false) }
    }
}
