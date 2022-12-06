import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from "@angular/router";


@Component({
  selector: 'app-signup-with-header-footer',
  templateUrl: './signup-with-header-footer.component.html',
  styleUrls: ['./signup-with-header-footer.component.scss']
})
export class SignupWithHeaderFooterComponent implements OnInit {

  constructor(private router: Router, private route: ActivatedRoute) { }

  // On Signup link click
  onSignIn() {
    this.router.navigate(['signin-with-header-footer'], { relativeTo: this.route.parent });
  }

  ngOnInit(): void {
  }

}
