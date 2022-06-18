import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-add-products',
  templateUrl: './add-products.component.html',
  styleUrls: ['./add-products.component.scss']
})
export class AddProductsComponent implements OnInit {

  selectedFile: File;
  retrievedImage: any;
  base64Data: any;
  retrieveResponse: any;
  message: string;
  imageName='hero image';

    productName:String;
    price:Number;
    category: String;
    subcategory:String;
    image:any;

  constructor() { }

  ngOnInit(): void {
  }

  onFileChanged(event:any) {
    this.selectedFile = event.target.files[0];
  }
   onUpload(){
     console.log(this.selectedFile);
   }


}
