package com.kadabra.agent.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class TicketModel {
    @SerializedName("TicketId")
    @Expose
    var ticketId: String? = null
    @SerializedName("TicketName")
    @Expose
    var ticketName: String = ""
    @SerializedName("TicketDescription")
    @Expose
    var ticketDescription: String = ""
    @SerializedName("Mobile")
    @Expose
    var userMobile: String = ""
    @SerializedName("StatusId")
    @Expose
    var statusId: Int ?=null
    @SerializedName("CategoryId")
    @Expose
    var categoryId: String = ""
    @SerializedName("PriorityId")
    @Expose
    var priorityId:  Int ?=null
    @SerializedName("PaymentId")
    @Expose
    var paymentId: Int ?=null
    @SerializedName("NeedCourier")
    @Expose
    var needCourier: Boolean ?= false
    @SerializedName("ServiceCost")
    @Expose
    var TicketServiceCost: ArrayList<TicketServiceCost>? = null
    @SerializedName("AdminId")
    @Expose
    var adminId: String = ""

    constructor()

    constructor(
        ticketId: String?,
        ticketName: String,
        ticketDescription: String,
        userMobile: String,
        categoryId: String,
        statusId: Int?,
        priorityId: Int?,
        paymentId: Int?,
        needCourier: Boolean?,
        TicketServiceCost: ArrayList<TicketServiceCost>?,
        adminId: String

    ) {
        this.ticketId = ticketId
        this.ticketName = ticketName
        this.ticketDescription = ticketDescription
        this.userMobile = userMobile
        this.statusId = statusId
        this.categoryId = categoryId
        this.priorityId = priorityId
        this.paymentId = paymentId
        this.needCourier = needCourier
        this.TicketServiceCost = TicketServiceCost
        this.adminId = adminId
    }

}
