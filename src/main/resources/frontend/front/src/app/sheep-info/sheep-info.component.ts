import { Component, Input, OnChanges, OnInit, SimpleChanges } from '@angular/core';

@Component({
  selector: 'app-sheep-info',
  templateUrl: './sheep-info.component.html',
  styleUrls: ['./sheep-info.component.scss']
})
export class SheepInfoComponent implements OnInit, OnChanges{

  @Input() sheep:any;
  constructor() { }

  ngOnChanges(changes: SimpleChanges): void {
  }

  ngOnInit(): void {
  }

}
