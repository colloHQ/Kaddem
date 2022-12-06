$(document).ready(function () {
	var $sidebar = $('.sidebar'),
		$sidebar_content = $('.sidebar-content'),
		$wrapper = $('.wrapper');
	if (!$wrapper.hasClass('toggled')) {
		$sidebar_content.find('li.active').parents('li').addClass('open');
	}
	$sidebar_content.on('click', '.navigation li a', function () {
		var $this = $(this),
			listItem = $this.parent('li');
		if (listItem.hasClass('sub') && listItem.hasClass('open')) {
			collapse(listItem);
		} else {
			if (listItem.hasClass('sub')) {
				expand(listItem);
			}
			// If menu collapsible then do not take any action
			if ($sidebar_content.data('collapsible')) {
				return false;
			}
			// If menu accordion then close all except clicked once
			else {
				openListItems = listItem.siblings('.open');
				collapse(openListItems);
				listItem.siblings('.open').find('li.open').removeClass('open');
			}
		}
	});

	function collapse($listItem, callback) {
		var $subList = $listItem.children('ul');
		$subList.show().slideUp(300, function () {
			$(this).css('display', '');
			$(this).find('> li').removeClass('is-shown');
			$listItem.removeClass('open');
			if (callback) {
				callback();
			}
		});
	}

	function expand($listItem, callback) {
		var $subList = $listItem.children('ul');
		var $children = $subList.children('li').addClass('is-hidden');
		$listItem.addClass('open');
		$subList.hide().slideDown(300, function () {
			$(this).css('display', '');
			if (callback) {
				callback();
			}
		});
		setTimeout(function () {
			$children.addClass('is-shown');
			$children.removeClass('is-hidden');
		}, 0);
	}

	// 
	$("#dark-switch").on("click", function(e) {
        e.preventDefault();
        $("html").toggleClass("dark-theme");
    });
	
	
});