import { HttpClient } from '@angular/common/http';
import { Component, Input, OnChanges, OnInit, SimpleChanges, ViewChild } from '@angular/core';
import { ITreeOptions, TreeComponent, TreeNode} from '@circlon/angular-tree-component';

@Component({
  selector: 'app-genealogy',
  templateUrl: './genealogy.component.html',
  styleUrls: ['./genealogy.component.scss']
})

export class GenealogyComponent implements OnInit, OnChanges {

  @Input() sheep:any;
  @ViewChild('tree')
  tree!: TreeComponent;

  nodes = [
    {
      id: 0,
      name:'',
      children: [
        {
          id: 1,
          name: ''
        },{
          id: 2,
          name: ''
        }
      ]
    }
  ];

  options: ITreeOptions = {
    idField: 'id'
    // displayField: 'nodeName',
    // isExpandedField: 'expanded',
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
    // Root creation
    this.nodes =[
      {
        id: this.genealogy[0].child.sheepId,
        name: this.genealogy[0].child.name,
        children: [
          {
            id: this.genealogy[0].father.sheepId,
            name: this.genealogy[0].father.name
          },{
            id: this.genealogy[0].mother.sheepId,
            name: this.genealogy[0].mother.name
          }
        ]
      }
    ];
    console.log(this.nodes);
    console.log(this.tree);
    for(let i = 1;i<this.genealogy.length;i++){
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
      this.nodes.push(newNode);
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
