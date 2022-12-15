import { Component, OnInit } from '@angular/core';
import { map } from 'rxjs';
import { UnivDepartService } from 'src/app/univ-depart/univ-depart.service';
import * as highchartsData from '../../shared/data/analytics.highchartsData';


@Component({
  selector: 'app-analytics',
  templateUrl: './analytics.component.html',
  styleUrls: ['./analytics.component.scss']
})
export class AnalyticsComponent implements OnInit {

  public repartition = {
    "TWIN" : 0,
    "Gamix" : 0,
    "NIDS" : 0,
    "SAE" : 0,
    "SE" : 0
  }

  constructor(private univDepartService: UnivDepartService) { }

  // Chart 2
  public Highcharts2 = highchartsData.Highcharts2;
  public chartOptions: Highcharts.Options 



  ngOnInit(): void {
    this.univDepartService.getRepartiton().subscribe((data: any) => {
      console.log(data.Gamix);
      let sum = 0
      sum = data.Gamix + data.TWIN + data.NIDS + data.SAE + data.SE
      console.log(sum)
      this.repartition["TWIN"] = data.TWIN
      console.log(data.Gamix)
      this.repartition["Gamix"] = data.Gamix
      this.repartition["NIDS"] = data.NIDS
      this.repartition["SAE"] = data.SAE
      this.repartition["SE"] = data.SE

      this.chartOptions = {
    
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
            text: "Etudiants par departement"
        },
        subtitle: {
            text: "Repartiton par option"
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
            name: "option",
            type: "pie",
            colorByPoint: !0,
            data: [{
                name: "TWIN",
                y: data["TWIN"]
            }, {
              name: "Gamix",
                y: data["Gamix"]
            }, {
              name: "SAE",
              y: data["SAE"]
            }, {
              name: "SE",
              y: data["SE"]
            },{
              name: "NIDS",
              y: data["NIDS"]
            },]
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

    });
  
    console.log(this.repartition["Gamix"])

    
    
  }

}
