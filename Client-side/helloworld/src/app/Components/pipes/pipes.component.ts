import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-pipes',
  templateUrl: './pipes.component.html',
  styleUrls: ['./pipes.component.css']
})
export class PipesComponent implements OnInit {

  employee = {
    "name": "jhony depp",
    "baseSalary": 56000000,
    "joinOn": Date.now(),
    "qualification": "B.Tech",
    "about": "John Christopher Depp II is an American actor and musician. He is the recipient of multiple accolades, including a Golden Globe Award and a Screen Actors Guild Award, in addition to nominations for three Academy Awards and two BAFTA awards.",
    "winningPercentage": 50 / 100
  }

  param: string=''
  constructor() { }

  ngOnInit(): void {
  }

}
