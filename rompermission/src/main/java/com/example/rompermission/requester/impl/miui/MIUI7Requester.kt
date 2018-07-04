package com.example.rompermission.requester.impl.miui

import android.content.Context
import android.content.Intent

class MIUI7Requester : MIUIRequester() {
    override fun applyAlterPermission(context: Context) {
        val intent = Intent("miui.intent.action.APP_PERM_EDITOR")
        intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity")
        intent.putExtra("extra_pkgname", context.packageName)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK

        if (isIntentAvailable(intent, context)) {
            context.startActivity(intent)
        }
    }
}