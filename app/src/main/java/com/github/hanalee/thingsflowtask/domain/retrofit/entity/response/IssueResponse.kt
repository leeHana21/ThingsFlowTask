package com.github.hanalee.thingsflowtask.domain.retrofit.entity.response


import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

class IssueResponse : ArrayList<IssueResponse.IssueItem>() {
    @Keep
    @Parcelize
    data class IssueItem(
        @SerializedName("active_lock_reason")
        val activeLockReason: @RawValue Any?,
        @SerializedName("assignee")
        val assignee: Assignee?,
        @SerializedName("assignees")
        val assignees: @RawValue List<Any?>?,
        @SerializedName("author_association")
        val authorAssociation: String?,
        @SerializedName("body")
        val body: String?,
        @SerializedName("closed_at")
        val closedAt: @RawValue Any?,
        @SerializedName("comments")
        val comments: Int?,
        @SerializedName("comments_url")
        val commentsUrl: String?,
        @SerializedName("created_at")
        val createdAt: String?,
        @SerializedName("draft")
        val draft: Boolean?,
        @SerializedName("events_url")
        val eventsUrl: String?,
        @SerializedName("html_url")
        val htmlUrl: String?,
        @SerializedName("id")
        val id: Int?,
        @SerializedName("labels")
        val labels: @RawValue List<Any?>?,
        @SerializedName("labels_url")
        val labelsUrl: String?,
        @SerializedName("locked")
        val locked: Boolean?,
        @SerializedName("milestone")
        val milestone: @RawValue Any?,
        @SerializedName("node_id")
        val nodeId: String?,
        @SerializedName("number")
        val number: Int?,
        @SerializedName("performed_via_github_app")
        val performedViaGithubApp: @RawValue Any?,
        @SerializedName("pull_request")
        val pullRequest: PullRequest?,
        @SerializedName("reactions")
        val reactions: Reactions?,
        @SerializedName("repository_url")
        val repositoryUrl: String?,
        @SerializedName("state")
        val state: String?,
        @SerializedName("timeline_url")
        val timelineUrl: String?,
        @SerializedName("title")
        val title: String?,
        @SerializedName("updated_at")
        val updatedAt: String?,
        @SerializedName("url")
        val url: String?,
        @SerializedName("user")
        val user: User?
    ) : Parcelable {
        @Keep
        @Parcelize
        data class Assignee(
            @SerializedName("avatar_url")
            val avatarUrl: String?,
            @SerializedName("events_url")
            val eventsUrl: String?,
            @SerializedName("followers_url")
            val followersUrl: String?,
            @SerializedName("following_url")
            val followingUrl: String?,
            @SerializedName("gists_url")
            val gistsUrl: String?,
            @SerializedName("gravatar_id")
            val gravatarId: String?,
            @SerializedName("html_url")
            val htmlUrl: String?,
            @SerializedName("id")
            val id: Int?,
            @SerializedName("login")
            val login: String?,
            @SerializedName("node_id")
            val nodeId: String?,
            @SerializedName("organizations_url")
            val organizationsUrl: String?,
            @SerializedName("received_events_url")
            val receivedEventsUrl: String?,
            @SerializedName("repos_url")
            val reposUrl: String?,
            @SerializedName("site_admin")
            val siteAdmin: Boolean?,
            @SerializedName("starred_url")
            val starredUrl: String?,
            @SerializedName("subscriptions_url")
            val subscriptionsUrl: String?,
            @SerializedName("type")
            val type: String?,
            @SerializedName("url")
            val url: String?
        ) : Parcelable

        @Keep
        @Parcelize
        data class PullRequest(
            @SerializedName("diff_url")
            val diffUrl: String?,
            @SerializedName("html_url")
            val htmlUrl: String?,
            @SerializedName("merged_at")
            val mergedAt: @RawValue Any?,
            @SerializedName("patch_url")
            val patchUrl: String?,
            @SerializedName("url")
            val url: String?
        ) : Parcelable

        @Keep
        @Parcelize
        data class Reactions(
            @SerializedName("confused")
            val confused: Int?,
            @SerializedName("eyes")
            val eyes: Int?,
            @SerializedName("heart")
            val heart: Int?,
            @SerializedName("hooray")
            val hooray: Int?,
            @SerializedName("laugh")
            val laugh: Int?,
            @SerializedName("rocket")
            val rocket: Int?,
            @SerializedName("total_count")
            val totalCount: Int?,
            @SerializedName("url")
            val url: String?,
            @SerializedName("+1")
            val plus1: Int?,
            @SerializedName("-1")
            val minus1: Int?
        ) : Parcelable

        @Keep
        @Parcelize
        data class User(
            @SerializedName("avatar_url")
            val avatarUrl: String?,
            @SerializedName("events_url")
            val eventsUrl: String?,
            @SerializedName("followers_url")
            val followersUrl: String?,
            @SerializedName("following_url")
            val followingUrl: String?,
            @SerializedName("gists_url")
            val gistsUrl: String?,
            @SerializedName("gravatar_id")
            val gravatarId: String?,
            @SerializedName("html_url")
            val htmlUrl: String?,
            @SerializedName("id")
            val id: Int?,
            @SerializedName("login")
            val login: String?,
            @SerializedName("node_id")
            val nodeId: String?,
            @SerializedName("organizations_url")
            val organizationsUrl: String?,
            @SerializedName("received_events_url")
            val receivedEventsUrl: String?,
            @SerializedName("repos_url")
            val reposUrl: String?,
            @SerializedName("site_admin")
            val siteAdmin: Boolean?,
            @SerializedName("starred_url")
            val starredUrl: String?,
            @SerializedName("subscriptions_url")
            val subscriptionsUrl: String?,
            @SerializedName("type")
            val type: String?,
            @SerializedName("url")
            val url: String?
        ) : Parcelable

        override fun toString(): String {
            return "IssueItem(activeLockReason=$activeLockReason, assignee=$assignee, assignees=$assignees, authorAssociation=$authorAssociation, body=$body, closedAt=$closedAt, comments=$comments, commentsUrl=$commentsUrl, createdAt=$createdAt, draft=$draft, eventsUrl=$eventsUrl, htmlUrl=$htmlUrl, id=$id, labels=$labels, labelsUrl=$labelsUrl, locked=$locked, milestone=$milestone, nodeId=$nodeId, number=$number, performedViaGithubApp=$performedViaGithubApp, pullRequest=$pullRequest, reactions=$reactions, repositoryUrl=$repositoryUrl, state=$state, timelineUrl=$timelineUrl, title=$title, updatedAt=$updatedAt, url=$url, user=$user)"
        }
    }
}