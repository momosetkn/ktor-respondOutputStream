package com.example;

import io.ktor.resources.Resource

class FileResources {
    @Resource("files/respond_output_stream")
    class RespondOutputStream

    @Resource("files2/workaround_with_respond_bytes")
    class WorkaroundWithRespondBytes
}
