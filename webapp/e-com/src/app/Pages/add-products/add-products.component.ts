import { Component, OnInit } from '@angular/core';
import { log } from 'util';
import { HttpClient } from '@angular/common/http';
import { AuthService } from '../../services/auth.service';

@Component({
	selector: 'app-add-products-page',
	templateUrl: './add-products.component.html',
	styleUrls: ['./add-products.component.scss'],
})
export class AddProductsComponent implements OnInit {
	url =
		'http://localhost:8080/Spring-helper-backend/api/products';
	public srcImage: any;
	productName: string;
	price: number;
	category: string;
	subcategory: string;
	description: string;
	image = [];
	imageName = [];
	subCategoryArray: Array<String>;
	subcategoryOption = {
		Others: ['others'],
		Stationary: ['Book', 'Pen', 'Pencil', 'PencilBox'],
		LifeStyle: [
			'Trouser',
			'T-shirt',
			'Shorts',
			'Top',
			'Shoes',
			'Slippers',
		],
		Electronics: [
			'LED',
			'Laptop',
			'Mobile phone',
			'Watch',
			'Headphone',
			'Other',
		],
	};
	public categoryError = false;
	public blobImage: Blob;
	fileBlob: any;
	public imageCount = 0;

	constructor(
		private httpClient: HttpClient,
		private authService: AuthService
	) {}

	ngOnInit(): void {}

	handleUpload(event: any) {
		if (this.imageCount < 5) {
			const file = event.target.files[0];
			// @ts-ignore
			this.imageName.push(file.name);
			this.convertImageToBase64(file);
			this.imageCount++;
		}
	}

	private convertBase64ToBlob(base64Image: string) {
		const parts = base64Image.split(';base64,');
		const imageType = parts[0].split(':')[1];
		const decodedData = window.atob(parts[1]);
		const uInt8Array = new Uint8Array(decodedData.length);
		for (let i = 0; i < decodedData.length; ++i) {
			uInt8Array[i] = decodedData.charCodeAt(i);
		}
		this.blobImage = new Blob([uInt8Array], {
			type: imageType,
		});
		// blob to base64
		this.blobToBase64(this.blobImage).then(res => {
			this.srcImage = res;
		});
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
			image: this.image,
			description: this.description,
		};
		console.log(data);
		this.httpClient.post<any>(this.url, data).subscribe(
			data => {
				console.log(data);
				alert('User Registration is done successfully');
			},
			e => {
				alert('Something went wrong');
			}
		);
	}

	async convertImageToBase64(theFile: any) {
		const reader = new FileReader();
		reader.readAsDataURL(theFile);
		reader.onload = () => {
			const base64Data = reader.result;
			// @ts-ignore
			this.image.push(base64Data);
		};
	}

	removeImage(i: number) {
		this.image.splice(i, 1);
		this.imageName.splice(i, 1);
		this.imageCount--;
	}

	checkCategory(type: String) {
		if (type === 'Others') {
			this.subCategoryArray = ['Others'];
			this.categoryError = false;
		} else if (type === 'Stationary') {
			this.subCategoryArray =
				this.subcategoryOption.Stationary;
			this.categoryError = false;
		} else if (type === 'Electronics') {
			this.subCategoryArray =
				this.subcategoryOption.Electronics;
			this.categoryError = false;
		} else if (type === 'Life style product') {
			this.subCategoryArray = this.subcategoryOption.LifeStyle;
			this.categoryError = false;
		} else this.categoryError = true;
	}
}
