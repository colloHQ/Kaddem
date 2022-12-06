import * as Highcharts from 'highcharts';

// Chart 1
export var Highcharts1: typeof Highcharts = Highcharts;
export var chartOptions1: Highcharts.Options = {

    chart: {
        height: 350,
        type: "column",
        styledMode: !0
    },
    credits: {
        enabled: !1
    },
    title: {
        text: "Traffic Sources Status. January, 2020"
    },
    accessibility: {
        announceNewData: {
            enabled: !0
        }
    },
    xAxis: {
        type: "category"
    },
    yAxis: {
        title: {
            text: "Total percent market share"
        }
    },
    legend: {
        enabled: !1
    },
    plotOptions: {
        series: {
            borderWidth: 0,
            dataLabels: {
                enabled: !0,
                format: "{point.y:.1f}%"
            }
        }
    },
    tooltip: {
        headerFormat: '<span style="font-size:11px">{series.name}</span><br>',
        pointFormat: '<span style="color:{point.color}">{point.name}</span>: <b>{point.y:.2f}%</b> of total<br/>'
    },
    series: [{
        name: "Traffic Sources",
        type: "column",
        colorByPoint: !0,
        data: [{
            name: "Organic Search",
            y: 62.74,
            drilldown: "Organic Search"
        }, {
            name: "Direct",
            y: 40.57,
            drilldown: "Direct"
        }, {
            name: "Referral",
            y: 25.23,
            drilldown: "Referral"
        }, {
            name: "Others",
            y: 10.58,
            drilldown: "Others"
        }]
    }],
    drilldown: {
        series: [{
            name: "Chrome",
            id: "Chrome",
            type: "column",
            data: [
                ["v65.0", .1],
                ["v64.0", 1.3],
                ["v63.0", 53.02],
                ["v62.0", 1.4],
                ["v61.0", .88],
                ["v60.0", .56],
                ["v59.0", .45],
                ["v58.0", .49],
                ["v57.0", .32],
                ["v56.0", .29],
                ["v55.0", .79],
                ["v54.0", .18],
                ["v51.0", .13],
                ["v49.0", 2.16],
                ["v48.0", .13],
                ["v47.0", .11],
                ["v43.0", .17],
                ["v29.0", .26]
            ]
        }, {
            name: "Firefox",
            id: "Firefox",
            type: "column",
            data: [
                ["v58.0", 1.02],
                ["v57.0", 7.36],
                ["v56.0", .35],
                ["v55.0", .11],
                ["v54.0", .1],
                ["v52.0", .95],
                ["v51.0", .15],
                ["v50.0", .1],
                ["v48.0", .31],
                ["v47.0", .12]
            ]
        }, {
            name: "Internet Explorer",
            id: "Internet Explorer",
            type: "column",
            data: [
                ["v11.0", 6.2],
                ["v10.0", .29],
                ["v9.0", .27],
                ["v8.0", .47]
            ]
        }, {
            name: "Safari",
            id: "Safari",
            type: "column",
            data: [
                ["v11.0", 3.39],
                ["v10.1", .96],
                ["v10.0", .36],
                ["v9.1", .54],
                ["v9.0", .13],
                ["v5.1", .2]
            ]
        }, {
            name: "Edge",
            id: "Edge",
            type: "column",
            data: [
                ["v16", 2.6],
                ["v15", .92],
                ["v14", .4],
                ["v13", .1]
            ]
        }, {
            name: "Opera",
            id: "Opera",
            type: "column",
            data: [
                ["v50.0", .96],
                ["v49.0", .82],
                ["v12.1", .14]
            ]
        }]
    }
    
  };


// Chart 2 

export var Highcharts2: typeof Highcharts = Highcharts;
export var chartOptions2: Highcharts.Options = {
    
    chart: {
        height: 350,
        plotBackgroundColor: null,
        plotBorderWidth: null,
        plotShadow: !1,
        type: "pie",
        styledMode: !0
    },
    credits: {
        enabled: !1
    },
    title: {
        text: "Sessions Device"
    },
    subtitle: {
        text: "Ratio of devices use by users"
    },
    tooltip: {
        pointFormat: "{series.name}: <b>{point.percentage:.1f}%</b>"
    },
    accessibility: {
        point: {
            valueSuffix: "%"
        }
    },
    plotOptions: {
        pie: {
            allowPointSelect: !0,
            cursor: "pointer",
            innerSize: 120,
            dataLabels: {
                enabled: !0,
                format: "<b>{point.name}</b>: {point.percentage:.1f} %"
            },
            showInLegend: !0
        }
    },
    series: [{
        name: "Users",
        type: "pie",
        colorByPoint: !0,
        data: [{
            name: "Desktop",
            y: 56
        }, {
            name: "Mobile",
            y: 30
        }, {
            name: "Tablet",
            y: 14
        }]
    }],
    responsive: {
        rules: [{
            condition: {
                maxWidth: 500
            },
            chartOptions: {
                plotOptions: {
                    pie: {
                        innerSize: 140,
                        dataLabels: {
                            enabled: !1
                        }
                    }
                }
            }
        }]
    }
};




// Chart 2 

export var Highcharts3: typeof Highcharts = Highcharts;
export var chartOptions3: Highcharts.Options = {
    
    chart: {
        type: "bar",
        styledMode: !0
    },
    credits: {
        enabled: !1
    },
    exporting: {
        buttons: {
            contextButton: {
                enabled: !1
            }
        }
    },
    title: {
        text: "Visitor by Gender"
    },
    xAxis: {
        categories: ["Jan", "Feb", "Mar", "Apr", "May"]
    },
    yAxis: {
        min: 0,
        title: {
            text: "Visitor by Genders",
            style: {
                display: "none"
            }
        }
    },
    legend: {
        reversed: !1
    },
    plotOptions: {
        series: {
            stacking: "normal"
        }
    },
    series: [{
        type: "bar",
        name: "Male",
        data: [5, 3, 4, 7, 2]
    }, {
        type: "bar",
        name: "Female",
        data: [2, 2, 3, 2, 1]
    }, {
        type: "bar",
        name: "Others",
        data: [3, 4, 4, 2, 5]
    }]

};
