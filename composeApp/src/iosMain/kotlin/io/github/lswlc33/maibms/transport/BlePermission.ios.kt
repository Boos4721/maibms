package io.github.lswlc33.maibms.transport

/**
 * iOS：CoreBluetooth 的权限由系统在首次访问 CBCentralManager 时自动弹窗，没有可预检的 API，
 * 因此这里直接放行——但「放行」不等于「能连上」：CBCentralManager 刚创建时 state 还是 unknown，
 * 真正状态是异步回调送来的，所以 IosBleTransport 的 scan()/findPeripheral() 都会先等状态就位
 * （awaitState），不会把「还没就绪」误报成「蓝牙未打开」。未授权时界面会拿到准确提示。
 */
actual fun canAutoConnect(): Boolean = true
