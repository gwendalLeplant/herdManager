import { HttpClient } from '@angular/common/http';
import { Component, Input, OnChanges, OnInit, SimpleChanges, ViewChild } from '@angular/core';
import { ITreeOptions, TreeComponent, TreeNode, TreeNodeComponent} from '@circlon/angular-tree-component';

@Component({
  selector: 'app-genealogy',
  templateUrl: './genealogy.component.html',
  styleUrls: ['./genealogy.component.scss']
})

export class GenealogyComponent implements OnInit, OnChanges {

  @Input() sheep:any;
  @ViewChild('tree')
  tree!: TreeComponent;

  nodes:any[] = [];

  options: ITreeOptions = {
    idField: 'id',
    // useVirtualScroll: true,
    // displayField: 'nodeName',
    // isExpandedField: 'expanded'
    // idField: 'id',
    // hasChildrenField: 'nodes',
    // nodeHeight: 23,
    // allowDrag: (node) => {
    //   return true;
    // },
    // allowDrop: (node) => {
    //   return true;
    // },
    // allowDragoverStyling: true,
    // levelPadding: 10,
    // useVirtualScroll: true,
    // animateExpand: true,
    // scrollOnActivate: true,
    // animateSpeed: 30,
    // animateAcceleration: 1.2,
    // scrollContainer: document.documentElement // HTML
  }
  genealogy:any[] = [];

  constructor(private httpClient:HttpClient) {}

  ngOnInit(): void {
  }

  ngOnChanges(changes: SimpleChanges) {
    if(this.sheep!=undefined){
       this.getGenealogy();
    }
  }

  getGenealogy(){
    let url ="http://localhost:8080/WS/sheep/genealogy/"+this.sheep.sheepId;
    let promise = this.httpClient.get<any[]>(url,{responseType:'json'}).subscribe(
      response => {
        if(response != undefined){
          this.genealogy = [];
        for(let o of response){
          this.genealogy.push(o);
        }
        this.updateTree();
      }
    });
  }

  updateTree() {
    for(let i = 0;i<this.genealogy.length;i++){
      let newNode =     {
        id: this.genealogy[i].child.sheepId,
        name: this.genealogy[i].child.name,
        children: [
          {
            id: this.genealogy[i].father.sheepId,
            name: this.genealogy[i].father.name
          },{
            id: this.genealogy[i].mother.sheepId,
            name: this.genealogy[i].mother.name 
          }
        ]
      }      
      if(i!=0){
        if(newNode.name!=""){
          const someNode = this.tree.treeModel.getNodeById(newNode.id);
          someNode.data.children = newNode.children;
        }
      }
      else{
        this.nodes.length = 0;
        this.nodes.push(newNode);        
      }
      this.tree.treeModel.update();      
    }     
  }  

  
  addNode(node: any) {
    const newNode = {name: 'new item'};
    if (!node.data.children) {
      node.data.children = [];
    }
    node.data.children.push(newNode);
    this.tree.treeModel.update();

    const someNode = this.tree.treeModel.getNodeById(node.id);
    someNode.expand();
  }
}
