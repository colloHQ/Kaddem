import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from "@angular/router";


@Component({
  selector: 'app-signin-with-header-footer',
  templateUrl: './signin-with-header-footer.component.html',
  styleUrls: ['./signin-with-header-footer.component.scss']
})
export class SigninWithHeaderFooterComponent implements OnInit {

  constructor(private router: Router, private route: ActivatedRoute) { }

  // On Forgotpassword link click
  onForgotpassword() {
    this.router.navigate(['forgot-password'], { relativeTo: this.route.parent });
  }

  // On Signup link click
  onSignup() {
    this.router.navigate(['signup-with-header-footer'], { relativeTo: this.route.parent });
  }


  ngOnInit(): void {
  }

}
