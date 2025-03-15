var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "64680",
        "ok": "61447",
        "ko": "3233"
    },
    "minResponseTime": {
        "total": "1",
        "ok": "2",
        "ko": "1"
    },
    "maxResponseTime": {
        "total": "28",
        "ok": "28",
        "ko": "11"
    },
    "meanResponseTime": {
        "total": "4",
        "ok": "4",
        "ko": "2"
    },
    "standardDeviation": {
        "total": "1",
        "ok": "1",
        "ko": "1"
    },
    "percentiles1": {
        "total": "4",
        "ok": "4",
        "ko": "2"
    },
    "percentiles2": {
        "total": "4",
        "ok": "4",
        "ko": "3"
    },
    "percentiles3": {
        "total": "5",
        "ok": "5",
        "ko": "3"
    },
    "percentiles4": {
        "total": "6",
        "ok": "6",
        "ko": "5"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 61447,
    "percentage": 95
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 0,
    "percentage": 0
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 0,
    "percentage": 0
},
    "group4": {
    "name": "failed",
    "count": 3233,
    "percentage": 5
},
    "meanNumberOfRequestsPerSecond": {
        "total": "46.87",
        "ok": "44.527",
        "ko": "2.343"
    }
},
contents: {
"req_create-book-56e35": {
        type: "REQUEST",
        name: "create-book",
path: "create-book",
pathFormatted: "req_create-book-56e35",
stats: {
    "name": "create-book",
    "numberOfRequests": {
        "total": "64680",
        "ok": "61447",
        "ko": "3233"
    },
    "minResponseTime": {
        "total": "1",
        "ok": "2",
        "ko": "1"
    },
    "maxResponseTime": {
        "total": "28",
        "ok": "28",
        "ko": "11"
    },
    "meanResponseTime": {
        "total": "4",
        "ok": "4",
        "ko": "2"
    },
    "standardDeviation": {
        "total": "1",
        "ok": "1",
        "ko": "1"
    },
    "percentiles1": {
        "total": "4",
        "ok": "4",
        "ko": "2"
    },
    "percentiles2": {
        "total": "4",
        "ok": "4",
        "ko": "3"
    },
    "percentiles3": {
        "total": "5",
        "ok": "5",
        "ko": "3"
    },
    "percentiles4": {
        "total": "6",
        "ok": "6",
        "ko": "5"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 61447,
    "percentage": 95
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 0,
    "percentage": 0
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 0,
    "percentage": 0
},
    "group4": {
    "name": "failed",
    "count": 3233,
    "percentage": 5
},
    "meanNumberOfRequestsPerSecond": {
        "total": "46.87",
        "ok": "44.527",
        "ko": "2.343"
    }
}
    }
}

}

function fillStats(stat){
    $("#numberOfRequests").append(stat.numberOfRequests.total);
    $("#numberOfRequestsOK").append(stat.numberOfRequests.ok);
    $("#numberOfRequestsKO").append(stat.numberOfRequests.ko);

    $("#minResponseTime").append(stat.minResponseTime.total);
    $("#minResponseTimeOK").append(stat.minResponseTime.ok);
    $("#minResponseTimeKO").append(stat.minResponseTime.ko);

    $("#maxResponseTime").append(stat.maxResponseTime.total);
    $("#maxResponseTimeOK").append(stat.maxResponseTime.ok);
    $("#maxResponseTimeKO").append(stat.maxResponseTime.ko);

    $("#meanResponseTime").append(stat.meanResponseTime.total);
    $("#meanResponseTimeOK").append(stat.meanResponseTime.ok);
    $("#meanResponseTimeKO").append(stat.meanResponseTime.ko);

    $("#standardDeviation").append(stat.standardDeviation.total);
    $("#standardDeviationOK").append(stat.standardDeviation.ok);
    $("#standardDeviationKO").append(stat.standardDeviation.ko);

    $("#percentiles1").append(stat.percentiles1.total);
    $("#percentiles1OK").append(stat.percentiles1.ok);
    $("#percentiles1KO").append(stat.percentiles1.ko);

    $("#percentiles2").append(stat.percentiles2.total);
    $("#percentiles2OK").append(stat.percentiles2.ok);
    $("#percentiles2KO").append(stat.percentiles2.ko);

    $("#percentiles3").append(stat.percentiles3.total);
    $("#percentiles3OK").append(stat.percentiles3.ok);
    $("#percentiles3KO").append(stat.percentiles3.ko);

    $("#percentiles4").append(stat.percentiles4.total);
    $("#percentiles4OK").append(stat.percentiles4.ok);
    $("#percentiles4KO").append(stat.percentiles4.ko);

    $("#meanNumberOfRequestsPerSecond").append(stat.meanNumberOfRequestsPerSecond.total);
    $("#meanNumberOfRequestsPerSecondOK").append(stat.meanNumberOfRequestsPerSecond.ok);
    $("#meanNumberOfRequestsPerSecondKO").append(stat.meanNumberOfRequestsPerSecond.ko);
}
