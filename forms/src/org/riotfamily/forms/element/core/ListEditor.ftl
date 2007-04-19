<div id="${element.id}" class="listEditor">
	<ul id="${items.id}" class="listItems">
		<#list items.elements as item>
			${item.render()}
		</#list>
	</ul>
	${addButton.render()}
	<#if element.sortable>
		<input type="hidden" name="${element.paramName}" id="${element.id}-order" />
	</#if>
</div>