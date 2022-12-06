import { ChartType } from 'chart.js';


//line chart

export var lineChartData: Array<any> = [

  { data: [6, 20, 14, 12, 17, 8, 10], label: 'Google' },
  { data: [5, 30, 16, 23, 8, 14, 11], label: 'Facebook' },

];
export var lineChartLabels: Array<any> = ['Mo', 'Tu', 'We', 'Th', 'Fr', 'Sa', 'Su'];
export var lineChartOptions: any = {
  animation: {
    duration: 1000, // general animation time
    easing: 'easeOutBack'
  },
  hover: {
    animationDuration: 1000, // duration of animations when hovering an item
    mode: 'label'
  },
  responsiveAnimationDuration: 1000, // animation duration after a resize
  responsive: true,
  maintainAspectRatio: false,
  legend: {
    display: true,
    labels: {
    fontColor: '#585757',  
    boxWidth:40
    },
  },
  scales: {
    xAxes: [{
      
      ticks: {
        beginAtZero:true,
        fontColor: '#585757',
        padding: 10
      },
      display: true,
      gridLines: {
        color: "rgba(0, 0, 0, 0.07)",
        drawTicks: false,
      },
      scaleLabel: {
        display: false,
        labelString: 'week'
      }
    }],
    yAxes: [{
      
      ticks: {
        beginAtZero:true,
        fontColor: '#585757',
        padding: 10
      },
      display: true,
      gridLines: {
        color: "rgba(0, 0, 0, 0.07)",
        drawTicks: false,
      },
      scaleLabel: {
        display: false,
        labelString: 'Value'
      }
    }]
  },
};
export var lineChartColors: Array<any> = [

  {

    fill: true,
    backgroundColor: "transparent",
    borderColor: "#0d6efd",
    pointRadius :"0",
    borderWidth: 4
  },
  {

    fill: true,
    backgroundColor: "transparent",
    borderColor: "#f41127",
    pointRadius :"0",
    borderWidth: 4
  },

];
export var lineChartLegend = true;
export var lineChartType : ChartType = 'line';


// barChart
export var barChartOptions: any = {
  scaleShowVerticalLines: false,
  responsive: true,
  maintainAspectRatio: false,
  legend: {
    display: true,
    labels: {
    fontColor: '#585757',  
    boxWidth:40
    }
  },
  scales: {
    xAxes: [{
      
    ticks: {
      beginAtZero:true,
      fontColor: '#585757'
    },
    gridLines: {
      display: true ,
      color: "rgba(0, 0, 0, 0.07)"
    },
    
    }],
    
    yAxes: [{
      ticks: {
        beginAtZero:true,
        fontColor: '#585757'
      },
      gridLines: {
        display: true ,
        color: "rgba(0, 0, 0, 0.07)"
      },
      }]
     
  }

};
export var barChartLabels: string[] = ['Mo', 'Tu', 'We', 'Th', 'Fr', 'Sa', 'Su'];
export var barChartType : ChartType = 'bar';
export var barChartLegend = true;

export var barChartData: any[] = [
  { barPercentage: .5, data: [13, 8, 20, 4, 18, 29, 25], label: 'Google' },
  { barPercentage: .5, data: [31, 20, 6, 16, 21, 4, 11], label: 'Facebook' }
];

export var barChartColors: Array<any> = [
  
  {
    backgroundColor: "#0d6efd"
  },
  {
    backgroundColor: "#f41127"
  },
];


// Pie
export var pieChartLabels: string[] = ["Africa", "Asia", "Europe", "Latin America", "North America"];
export var pieChartData: number[] = [2478, 5267, 734, 784, 433];
export var pieChartType: ChartType = 'pie';
export var pieChartColors: any[] = [{ backgroundColor: ["#0d6efd", "#212529", "#17a00e", "#f41127", "#ffc107"] }];
export var pieChartOptions: any = {
  responsive: true,
  maintainAspectRatio: false,
  title: {
    display: true,
    text: 'Predicted world population (millions) in 2050'
  }

};


// Radar
 export var radarChartData: any[] =  [{
        label: "1950",
        fill: true,
        backgroundColor: "rgb(13 110 253 / 23%)",
        borderColor: "#0d6efd",
        pointBorderColor: "#fff",
        pointBackgroundColor: "rgba(179,181,198,1)",
        data: [8.77, 55.61, 21.69, 6.62, 6.82]
      }, {
        label: "2050",
        fill: true,
        backgroundColor: "rgba(255,99,132,0.2)",
        borderColor: "rgba(255,99,132,1)",
        pointBorderColor: "#fff",
        pointBackgroundColor: "rgba(255,99,132,1)",
        data: [25.48, 54.16, 7.61, 8.06, 4.45]
      }];

 export var radarChartOptions : any = {

    maintainAspectRatio: false,
    title: {
      display: true,
      text: 'Distribution in % of world population'
    }
  }
 export var radarChartLabels : any[] = ["Africa", "Asia", "Europe", "Latin America", "North America"];
 export var radarChartType: ChartType = 'radar';


// Polor
export var polorChartLabels: string[] = ["Lable1", "Lable2", "Lable3", "Lable4"];["Africa", "Asia", "Europe", "Latin America", "North America"];
export var polorChartData: number[] = [2478, 5267, 734, 784, 433];
export var polorChartType: ChartType = 'polarArea';
export var polorChartColors: any[] = [{ backgroundColor: ["#0d6efd", "#212529", "#17a00e", "#f41127", "#ffc107"], borderWidth: [0, 0, 0, 0, 0] }];
export var polorChartOptions: any = {
  maintainAspectRatio: false,
  title: {
    display: true,
    text: 'Predicted world population (millions) in 2050'
  }
};


// Doughnut
export var doughnutChartLabels: string[] = ["Africa", "Asia", "Europe", "Latin America", "North America"];
export var doughnutChartData: number[] = [2478, 5267, 734, 784, 433];
export var doughnutChartColors: any[] = [{ backgroundColor: ["#0d6efd", "#212529", "#17a00e", "#f41127", "#ffc107"] , borderWidth: [0, 0, 0, 0, 0]}];
export var doughnutChartType: ChartType = 'doughnut';
export var doughnutChartOptions: any = {
  maintainAspectRatio: false,
  title: {
    display: true,
    text: 'Predicted world population (millions) in 2050'
  }
};


// Horizontal Bar Chart
export var horizontalbarChartOptions: any = {
    maintainAspectRatio: false,
    legend: {
      display: false
    },
    title: {
      display: true,
      text: 'Predicted world population (millions) in 2050'
    }
  }
export var horizontalbarChartLabels: string[] = ["Africa", "Asia", "Europe", "Latin America", "North America"];
export var horizontalbarChartType : ChartType = 'horizontalBar';
export var horizontalbarChartLegend = true;

export var horizontalbarChartData: any[] = [
  {
    label: "Population (millions)",
    backgroundColor: ["#0d6efd", "#212529", "#17a00e", "#f41127", "#ffc107"],
    data: [2478, 5267, 734, 784, 433]
  }
];

export var horizontalbarChartColors: Array<any> = [
  
  { backgroundColor: ["#0d6efd", "#212529", "#17a00e", "#f41127", "#ffc107"] }
];

// Grouped Bar Chart
export var groupedbarChartOptions: any =  {
  maintainAspectRatio: false,
  title: {
    display: true,
    text: 'Population growth (millions)'
  }
}
export var groupedbarChartLabels: string[] = ["1900", "1950", "1999", "2050"];
export var groupedbarChartType : ChartType = 'bar';
export var groupedbarChartLegend = true;

export var groupedbarChartData: any[] = [{
  label: "Africa",
  data: [133, 221, 783, 2478]
}, {
  label: "Europe",
  backgroundColor: "#f02769",
  data: [408, 547, 675, 734]
}];

export var groupedbarChartColors: any[] = [
  { backgroundColor: "#0d6efd", },
  { backgroundColor: "#f41127", }
];


// Mixed Chart
export var mixedbarChartOptions: any =  {
  maintainAspectRatio: false,
  title: {
    display: true,
    text: 'Population growth (millions): Europe & Africa'
  },
  legend: {
    display: false
  }
}
export var mixedbarChartLabels: string[] = ["1900", "1950", "1999", "2050"];
export var mixedbarChartType : ChartType = 'bar';
export var mixedbarChartLegend = true;

export var mixedbarChartData: any[] = [{
        label: "Europe",
        type: "line",
        borderColor: "#673ab7",
        data: [408, 547, 675, 734],
        fill: false
      }, {
        label: "Africa",
        type: "line",
        borderColor: "#f02769",
        data: [133, 221, 783, 2478],
        fill: false
      }, {
        label: "Europe",
        type: "bar",
        backgroundColor: "rgba(0,0,0,0.2)",
        data: [408, 547, 675, 734],
      }, {
        label: "Africa",
        type: "bar",
        backgroundColor: "rgba(0,0,0,0.2)",
        backgroundColorHover: "#3e95cd",
        data: [133, 221, 783, 2478]
      }];

export var mixedbarChartColors: any[] = [
  { 
    borderColor: "#673ab7",
   },
   {
    borderColor: "#f02769",
   },
   {
    backgroundColor: "rgba(0,0,0,0.2)",
   },
   {
    backgroundColor: "rgba(0,0,0,0.2)",
   }

]


// Bubble
export var bubbleChartData: any[] = [{
      label: ["China"],
      backgroundColor: "#17a00e",
      borderColor: "#17a00e",
      data: [{
        x: 21269017,
        y: 5.245,
        r: 15
      }]
    }, {
      label: ["Denmark"],
      backgroundColor: "#ffc107",
      borderColor: "#ffc107",
      data: [{
        x: 258702,
        y: 7.526,
        r: 10
      }]
    }, {
      label: ["Germany"],
      backgroundColor: "#17a00e",
      borderColor: "#17a00e",
      data: [{
        x: 3979083,
        y: 6.994,
        r: 15
      }]
    }, {
      label: ["Japan"],
      backgroundColor: "#f41127",
      borderColor: "#f41127",
      data: [{
        x: 4931877,
        y: 5.921,
        r: 15
      }]
    }]
export var bubbleChartOptions: any = {
      maintainAspectRatio: false,
			title: {
				display: true,
				text: 'Predicted world population (millions) in 2050'
			},
			scales: {
				yAxes: [{
					scaleLabel: {
						display: true,
						labelString: "Happiness"
					}
				}],
				xAxes: [{
					scaleLabel: {
						display: true,
						labelString: "GDP (PPP)"
					}
				}]
			}
    };

export var bubbleChartLegend = true;

export var bubbleChartType: ChartType = 'bubble';