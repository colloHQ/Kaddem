import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-add-new-products',
  templateUrl: './add-new-products.component.html',
  styleUrls: ['./add-new-products.component.scss']
})
export class AddNewProductsComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
    
    $.getScript('./assets/plugins/Drag-And-Drop/imageuploadify.min.js');
    $.getScript("./assets/js/add-new-product-image-upload.js")
  }

}
