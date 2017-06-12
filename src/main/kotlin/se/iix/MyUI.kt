package se.iix

import javax.servlet.annotation.WebServlet

import com.vaadin.annotations.Theme
import com.vaadin.annotations.VaadinServletConfiguration
import com.vaadin.server.VaadinRequest
import com.vaadin.server.VaadinServlet
import com.vaadin.ui.*

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
class MyUI: UI() {

    override fun init(vaadingRequest: VaadinRequest) {
        val layout: VerticalLayout = VerticalLayout()
        
        val name: TextField = TextField()
        name.caption = "Type your name here:"

        val button: Button = Button("Click Me")
        button.addClickListener( fun(e) {
            layout.addComponent(Label ("Thanks ${name.value}, it works!"))
        })
        
        layout.addComponents(name, button)

        content = layout
    }

    companion object {
        @WebServlet(urlPatterns = arrayOf("/*"), name = "MyUIServlet", asyncSupported = true)
        @VaadinServletConfiguration(ui = MyUI::class, productionMode = false)
        class MyUIServlet : VaadinServlet()
    }
}
