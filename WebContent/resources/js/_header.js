/**
 * 
 */

const menuIcon = document.querySelector(".hamburger-button");
const mobileNav = document.querySelector(".nav--mobile");

// adds and removes the "change" class from the navbar when you click on the hamburger-menu
	menuIcon.addEventListener("click", () => {
  	mobileNav.classList.toggle("active");
});
