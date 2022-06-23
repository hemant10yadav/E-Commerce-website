import {Component, OnInit} from '@angular/core';
import {log} from "util";
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-add-products',
  templateUrl: './add-products.component.html',
  styleUrls: ['./add-products.component.scss']
})
export class AddProductsComponent implements OnInit {

  url = 'http://localhost:8080/Spring-helper-backend/products/save';
  public srcImage: any;
  productName: String;
  price: Number;
  category: String;
  subcategory: String;
  image=[];

  public blobImage: Blob;
  fileBlob: any;

  constructor(private httpClient: HttpClient) {
  }

  ngOnInit(): void {
  }

  handleUpload(event: any) {
    const file = event.target.files[0];
    this.convertImageToBase64(file);
  }

  private convertBase64ToBlob(base64Image: string) {
    const parts = base64Image.split(';base64,');
    const imageType = parts[0].split(':')[1];
    const decodedData = window.atob(parts[1]);
    const uInt8Array = new Uint8Array(decodedData.length);
    for (let i = 0; i < decodedData.length; ++i) {
      uInt8Array[i] = decodedData.charCodeAt(i);
    }
    this.blobImage = new Blob([uInt8Array], {type: imageType});
    // blob to base64
    this.blobToBase64(this.blobImage).then((res) => {
      this.srcImage = res;
    })
  }

  blobToBase64(blob: any) {
    return new Promise((resolve, _) => {
      const reader = new FileReader();
      reader.onloadend = () => resolve(reader.result);
      const hem = reader.readAsDataURL(blob);
      this.srcImage = hem;
    });
  }

  save() {
    const data = {
      productName: this.productName,
      price: this.price,
      category: this.category,
      subcategory: this.subcategory,
      image: this.image
    }
    console.log(data);
    this.httpClient.post<any>(this.url, data).subscribe(data => {
      alert("User Registration is done successfully")
    }, (e) => {
      alert("Something went wrong");
    })
  }

  async convertImageToBase64(theFile: any) {
    const reader = new FileReader();
    reader.readAsDataURL(theFile);
    reader.onload = () => {
      const base64Data = reader.result;
      // @ts-ignore
      this.image.push(base64Data)
    }
  }

  removeImage(i: number) {
   this.image.splice(i,1);
   console.log(this.image)
  }
}
