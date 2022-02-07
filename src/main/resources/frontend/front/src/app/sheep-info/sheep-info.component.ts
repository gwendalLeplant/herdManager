import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-sheep-info',
  templateUrl: './sheep-info.component.html',
  styleUrls: ['./sheep-info.component.scss']
})
export class SheepInfoComponent implements OnInit {

  @Input() sheep:any;
  constructor() { }

  ngOnInit(): void {
  }

}
