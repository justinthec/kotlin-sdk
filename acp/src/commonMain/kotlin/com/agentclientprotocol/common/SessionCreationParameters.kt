package com.agentclientprotocol.common

import com.agentclientprotocol.annotations.UnstableApi
import com.agentclientprotocol.model.McpServer
import com.agentclientprotocol.model.SystemPrompt
import kotlinx.serialization.json.JsonElement

@Deprecated("Use SessionCreationParameters instead")
public typealias SessionParameters = SessionCreationParameters

/**
 * Parameters for opening a session with `session/new`, `session/load`, `session/resume`, or `session/fork`.
 *
 * @property systemPrompt system-level instructions for the session. [com.agentclientprotocol.client.Client] fails
 * with [com.agentclientprotocol.protocol.AcpExpectedError] before sending if the content is empty or the agent did not
 * advertise `sessionCapabilities.systemPrompt` (and `mode.override` for
 * [OVERRIDE][com.agentclientprotocol.model.SystemPromptMode.OVERRIDE]). An agent should reject a mode or content
 * block type it does not support with [com.agentclientprotocol.protocol.jsonRpcInvalidParams]
 */
public class SessionCreationParameters(
    public val cwd: String,
    public val mcpServers: List<McpServer>,
    @property:UnstableApi
    public val additionalDirectories: List<String>? = null,
    public val systemPrompt: SystemPrompt? = null,
    public val _meta: JsonElement? = null
)