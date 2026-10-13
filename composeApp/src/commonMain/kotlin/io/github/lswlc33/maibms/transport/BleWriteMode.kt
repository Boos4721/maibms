package io.github.lswlc33.maibms.transport

internal enum class BleWriteMode { WithoutResponse, WithResponse }

/** Select a write type actually advertised by the discovered characteristic. */
internal fun bleWriteMode(withoutResponse: Boolean, withResponse: Boolean): BleWriteMode = when {
    withoutResponse -> BleWriteMode.WithoutResponse
    withResponse -> BleWriteMode.WithResponse
    else -> error("特征不可写")
}
