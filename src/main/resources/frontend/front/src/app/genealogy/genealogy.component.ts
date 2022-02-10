import { HttpClient } from '@angular/common/http';
import { TreeComponent, TreeModel, TreeModule, TreeNode } from '@circlon/angular-tree-component';
import { Component, Input, OnChanges, OnInit, SimpleChanges, ViewChild } from '@angular/core';
import { first } from 'rxjs';

@Component({
  selector: 'app-genealogy',
  templateUrl: './genealogy.component.html',
  styleUrls: ['./genealogy.component.scss']
})

export class GenealogyComponent implements OnInit, OnChanges {

  @ViewChild('tree')
  treeComponent!: TreeComponent;
  @Input() sheep:any;
  genealogy:any[] = [];
  options = {};
  nodes = [];
  constructor(private httpClient:HttpClient) {}

  ngOnInit(): void {
  }

  ngAfterInit(){
    const treeModel:TreeModel = this.treeComponent.treeModel;
    const firstNode:TreeNode = treeModel.getFirstRoot();
    
    firstNode.setActiveAndVisible();
  }

  ngOnChanges(changes: SimpleChanges): void {
    if(this.sheep!=undefined){
      this.getGenealogy();
      this.updateTree();
    }
  }


  updateTree() {
    for(let sheep of this.genealogy){
      let newNode = {id:sheep.sheepId,name:sheep.sheepId}
      this.treeComponent.treeModel.getFirstRoot.apply(newNode);
    }    
    this.treeComponent.treeModel.update();
  }

  getGenealogy(){
    let url ="http://localhost:8080/WS/sheep/genealogy/"+this.sheep.sheepId;
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
