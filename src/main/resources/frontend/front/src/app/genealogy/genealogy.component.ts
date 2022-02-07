import { HttpClient } from '@angular/common/http';
import { Component, Input, OnChanges, OnInit, SimpleChanges } from '@angular/core';

@Component({
  selector: 'app-genealogy',
  templateUrl: './genealogy.component.html',
  styleUrls: ['./genealogy.component.scss']
})

export class GenealogyComponent implements OnInit, OnChanges {

  @Input() sheepId:number = 10;
  genealogy:any[] = [];
  constructor(private httpClient:HttpClient) { }

  ngOnInit(): void {
    this.getGenealogy();
  }

  ngOnChanges(changes: SimpleChanges): void {
    this.getGenealogy();
  }

  getGenealogy(){
    let url ="http://localhost:8080/WS/sheep/genealogy/"+this.sheepId;
    this.httpClient.get<any[]>(url,{responseType:'json'}).subscribe(
      response => {
        if(response != undefined){
          this.genealogy = [];
        for(let o of response){
          this.genealogy.push(o);
        }
      }
    });
  }
  
}
